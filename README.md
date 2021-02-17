# Coding Interviews

Preparation and practice for coding interviews

Hope you enjoy and help is more than welcome :)

# Problems by Dificulty

## A1
1D problems, arithmetic

- binomial-coef
- counting-swaps
- hills-count
- last-repeat
- parent/val
- rom-to-dec

## A2
2D problems, simulations

- gifting-groups
- queens-II
- star-ratings

## B1
Hashes, Dynamic Programming

## B2
Union-Find

- cheap-trip
- countries-count
- path-find

## C1
Graphs, Trees & Abstract Data Structures

- robot-loop

## C2
Notorious Algorithms & Extra Challenges

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