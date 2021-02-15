#/bin/sh
mkdir -p ./artifacts
./codebuild_build.sh -i aws/codebuild/standard:4.0 -a ./artifacts
