#!/bin/bash
set -x #echo on

export AWS_PROFILE=c4ads
export AWS_REGION=us-west-1


# build the project
cd ../..
mvn clean package

# return to services module
cd ms-services/example-service

# process CF template and copy jars onto s3 for deployment
aws cloudformation package --template-file sam.yaml --output-template-file target/output-sam.yaml --s3-bucket serverless-spring-sample-deploy

# deploy CF template
aws cloudformation deploy --template-file target/output-sam.yaml --stack-name ExampleServiceStack --capabilities CAPABILITY_IAM --region=${AWS_REGION}

# print results (deployed stack description)
aws cloudformation describe-stacks --stack-name ExampleServiceStack --region=${AWS_REGION}