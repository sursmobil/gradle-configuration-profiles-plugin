package org.sursmobil.profiles.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by CJ on 19/10/2015.
 */
class ListProfiledFiles extends DefaultTask {

    @TaskAction
    void print() {
        project.extensions.profiledFiles.files.each {
            println it.path
        }
    }
}
