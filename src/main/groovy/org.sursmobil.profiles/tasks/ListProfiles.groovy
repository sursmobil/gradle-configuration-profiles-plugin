package org.sursmobil.profiles.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by CJ on 19/10/2015.
 */
class ListProfiles extends DefaultTask {

    @TaskAction
    void print() {
        project.extensions.profiles.each {
            println it.name
        }
    }
}
