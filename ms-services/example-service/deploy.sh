#!/bin/bash
set -x #echo on

# define your credential using profile or any other approaches
# you can comment next line and configure WS cli using command 'aws configure'
export AWS_PROFILE=<YOUR-AWS-CREDENTIALS-PROFILE>

# define your AWS region (you can use any region with serverless architecture support)
export AWS_REGION=us-west-1

# create an s3 bucket abd define the name of backet here:
export S3_DEPLOY_BUCKET=<YOUR-S3-BUCKET-NAME>

# define your CF stack name (can leave as is)
export CLOUD_FORMATION_STACK_NAME=ExampleServiceStack

# build the project
cd ../..
mvn clean package

# return to services module
cd ms-services/example-service

# process CF template and copy jars onto s3 for deployment
aws cloudformation package --template-file sam.yaml --output-template-file target/output-sam.yaml --s3-bucket ${S3_DEPLOY_BUCKET}

# deploy CF template
aws cloudformation deploy --template-file target/output-sam.yaml --stack-name ${CLOUD_FORMATION_STACK_NAME} --capabilities CAPABILITY_IAM --region=${AWS_REGION}

# print results (deployed stack description)
aws cloudformation describe-stacks --stack-name ExampleServiceStack --region=${AWS_REGION}