#!groovy

node ('hdp.sandbox') {
    stage('SCM Checkout') {
        checkout([$class: 'GitSCM',
                  branches: [[name: "${env.BRANCH_NAME}"]],
                  browser: [$class: 'Stash', repoUrl: 'https://github.com/chrisRedwine/SparkExamples'],
                  doGenerateSubmoduleConfigurations: false,
                  extensions: [[$class: 'CleanBeforeCheckout']],
                  submoduleCfg: [],
                  userRemoteConfigs: [[credentialsId: '9aad8dd5-ece4-48a1-ac9d-b8778c59afc6',
                                       url: 'https://github.com/chrisRedwine/SparkExamples.git']]])
    }

    stage('Build/Analyze/Test') {
        steps.sh 'chmod +x ./gradlew && ./gradlew clean build'
    }

    stage('Publish Test Results') {
        step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
    }
}
