# CodingInterviews

Preparation and practice for coding interviews


# Running this repo with CodeBuild (all languages)

git clone https://github.com/aws/aws-codebuild-docker-images.git
cd  aws-codebuild-docker-images/ubuntu/standard/4.0
docker build -t aws/codebuild/standard:4.0 .
docker pull amazon/aws-codebuild-local:latest --disable-content-trust=false
wget https://raw.githubusercontent.com/aws/aws-codebuild-docker-images/master/local_builds/codebuild_build.sh