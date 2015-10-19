package org.sursmobil.profiles.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.sursmobil.profiles.Profile

/**
 * Created by CJ on 19/10/2015.
 */
class ShowProfile extends DefaultTask {

    Profile profile

    @TaskAction
    void describe() {
        println "Profile $profile.name"
        profile.variables.each { k, v ->
            println "$k : $v"
        }
    }
}
