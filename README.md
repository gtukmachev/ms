# Run your Java/Kotlin Spring AWS-Lambda functions locally  
 
todo: describe modules

## Installation

You have to install 'AWS cli' for using scripts within the project.

```
$ cd ms-services/example-service/
```

Open and edit the file 'deploy.sh' within the folder (PROJECT_ROOT/ms-services/example-service/).
Ypu have to define several values in top of the file:

```
# define your credential using profile or any other approaches
# you can comment next line and configure WS cli using command 'aws configure'
export AWS_PROFILE=<YOUR-AWS-CREDENTIALS-PROFILE>

# define your AWS region (you can use any region with serverless architecture support)
export AWS_REGION=us-west-1

# create an s3 bucket abd define the name of backet here:
export S3_DEPLOY_BUCKET=<YOUR-S3-BUCKET-NAME>

# define your CF stack name (can leave as is)
export CLOUD_FORMATION_STACK_NAME=ExampleServiceStack
```

Then - run this script:
```
PROJECT_ROOT/ms-services/example-service/$ ./deploy.sh
```
This command should run maven to clean and package your services, and then - deploy CloudFormation stack 
with your services to AWS.

Find in output of the script strings:
```
"OutputValue": "https://**********.execute-api.us-west-1.amazonaws.com/Prod/foo/list"
"OutputValue": "https://**********.execute-api.us-west-1.amazonaws.com/Prod/bar/info"
```
this is your URL for call deployed functions  