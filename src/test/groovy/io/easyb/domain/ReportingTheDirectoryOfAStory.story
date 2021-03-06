package io.easyb.domain

import io.easyb.domain.Story

def testSourceDir = System.getProperty("easyb.test.source.dir")
def reportsDir = System.getProperty("easyb.reports.dir")

scenario "the story file should be stored in the Groovy binding",  {
  given "a story to be read from a directory", {
	  storyFilePath = "${testSourceDir}/groovy/io/easyb/bdd/story/stack/EmptyStackStory.groovy"
    story = new Story(new GroovyShellConfiguration(), "a phrase", new File(storyFilePath))
  }		
  when "we execute this story", {
	  initialStep = story.execute()
  }
  then "the story name is also stored in the binding", {
	  initialStep.context.sourceFile.name.shouldBe "EmptyStackStory.groovy"
  }
}

scenario "the specification file should be stored in the Groovy binding",  {
	given "a story to be read from a directory", {
      pathsep = File.separator
      specFilePath = "${testSourceDir}${pathsep}groovy${pathsep}io${pathsep}easyb${pathsep}bdd${pathsep}specification${pathsep}queue${pathsep}QueueSpecification.groovy"
	  spec = new Specification(new GroovyShellConfiguration(), "a phrase", new File("${testSourceDir}/groovy/io/easyb/bdd/specification/queue/QueueSpecification.groovy"))
	}
	when "we execute this spec", {
		initialStep = spec.execute()
	}
	then "the story path is stored in the binding", {
		initialStep.context.sourceFile.shouldNotBe null
        initialStep.context.sourceFile.path.shouldEqual specFilePath
	}
	then "the story name is also stored in the binding", {
		initialStep.context.sourceFile.name.shouldBe "QueueSpecification.groovy"
	}
  }
  