job('ejemplo-job-DSL') {
  	description('Job DSL de ejemplo para el curso de Jenkins')
    scm {
        git('https://github.com/macloujulian/jenkins.job.parametrizado.git','main') { node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('me@me.com')
        }
    }
    parameters {
        stringParam('nombre', defaultValue = 'Adrian', description = 'Parametro de cadena')        
        choiceParam('planeta', ['Mercurio', 'Tierra', 'Urano'])
        booleanParam('agente', false)
    }
    triggers {
        cron('H/7 * * * *')
    }
  	steps {
  		shell("bash jobscript.sh")
    }
  	publishers {
  		mailer('aquirozsotil@gmail.com', true,true)
    }
}
