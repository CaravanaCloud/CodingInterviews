# CodingInterviews

Preparation and practice for coding interviews

# Test Reports (Build at AWS)

* http://codinginterviews.caravana.cloud/java/
* http://codinginterviews.caravana.cloud/python/rom-to-dec.html

# Local Build
```
git clone https://github.com/aws/aws-codebuild-docker-images.git
cd  aws-codebuild-docker-images/ubuntu/standard/4.0
docker build -t aws/codebuild/standard:4.0 .
docker pull amazon/aws-codebuild-local:latest --disable-content-trust=false
./build.sh
```