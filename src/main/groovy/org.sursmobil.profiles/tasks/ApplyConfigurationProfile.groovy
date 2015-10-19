package org.sursmobil.profiles.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.sursmobil.profiles.Profile

/**
 * Created by CJ on 19/10/2015.
 */
class ApplyConfigurationProfile extends ProfilesPluginTask {

    ApplyConfigurationProfile() {
        description = "Apply configuration profile to all profiled files."
    }

    @TaskAction
    void applyProfile() {
        Profile p
        if(project.hasProperty('configuration-profile')) {
            def profileName = project.properties['configuration-profile']
            p = project.extensions.profiles."$profileName"
        } else if(project.extensions.profiles.default) {
            p = project.extensions.profiles.default
        }

        project.extensions.profiledFiles.files.each {
            def file = project.file(it.path)
            def text = file.text
            p.variables.each {k, v ->
                text = text.replaceAll("%$k%", "$v")
            }
            project.file("${it.destDir}").mkdirs()
            project.file("${it.destDir}/${file.name}").text = text
        }
    }
}
