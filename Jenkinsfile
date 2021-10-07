library identifier: '3scale-toolbox-jenkins@master',
        retriever: modernSCM([$class: 'GitSCMSource',
                              remote: 'https://github.com/rh-integration/3scale-toolbox-jenkins.git'])


  stage("Prepare") {
    service = toolbox.prepareThreescaleService(
        openapi: [ filename: "swagger.json" ],
        environment: [ baseSystemName: "my_service" ],
        toolbox: [ openshiftProject: "toolbox",
                   destination: "3scale-tenant",
                   secretName: "3scale-toolbox" ],
        service: [:],
        applications: [
            [ name: "my-test-app", description: "This is used for tests", plan: "test", account: "<CHANGE_ME>" ]
        ],
        applicationPlans: [
          [ systemName: "test", name: "Test", defaultPlan: true, published: true ],
          [ systemName: "silver", name: "Silver" ],
          [ artefactFile: "https://raw.githubusercontent.com/redhatHameed/API-Lifecycle-Mockup/master/testcase-01/plan.yaml"],
        ]
    )

    echo "toolbox version = " + service.toolbox.getToolboxVersion()
  }

  