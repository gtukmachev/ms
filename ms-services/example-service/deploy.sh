export AWS_PROFILE=c4ads
export AWS_REGION=us-west-1
aws cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket serverless-spring-sample-deploy
aws cloudformation deploy --template-file output-sam.yaml --stack-name ExampleServiceStack --capabilities CAPABILITY_IAM --region=us-west-1