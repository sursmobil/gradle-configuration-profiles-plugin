package org.sursmobil.profiles.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by CJ on 19/10/2015.
 */
class ListProfiles extends ProfilesPluginTask {

    ListProfiles() {
        description = "List all profiles for given project. Format is 'Profiles = {<profiles_joined_with_space>}"
    }

    @TaskAction
    void print() {
        def profiles = project.extensions.profiles.collect { it.name }.join(' ')
        println "Profiles = {$profiles}"
    }
}
