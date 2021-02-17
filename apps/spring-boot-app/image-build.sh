#!/bin/sh

. ./settings.sh

docker pull ${JAVA_BUILDER_IMAGE}

s2i build ${GIT_REPO_URL} ${JAVA_BUILDER_IMAGE} --context-dir=${FRUITS_CONTEXT_DIR} ${FRUITS_IMAGE}
docker tag ${FRUITS_IMAGE} quay.io/${USERNAME}/${FRUITS_IMAGE}
docker push quay.io/${USERNAME}/${FRUITS_IMAGE}

#docker logs $(docker ps | grep ${JAVA_BUILDER_IMAGE} | awk -F ' ' '{print $1}')