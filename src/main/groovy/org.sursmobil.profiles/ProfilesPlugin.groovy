package org.sursmobil.profiles

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.sursmobil.profiles.tasks.*

/**
 * Created by CJ on 19/10/2015.
 */
class ProfilesPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        def profiles = project.container(Profile)
        def files = new ProfiledFiles(project)
        project.extensions.profiles = profiles
        project.extensions.profiledFiles = files
        project.tasks.create("listProfiles", ListProfiles)
        project.tasks.create("listProfiledFiles", ListProfiledFiles)
        project.tasks.create("applyConfigurationProfile", ApplyConfigurationProfile)
        project.afterEvaluate addDescribeProfileTasks(project)
    }

    static Closure addDescribeProfileTasks(Project project) { return {
        project.extensions.profiles.each { Profile p ->
            project.task([type: ShowProfile], "showProfile${p.name.capitalize()}") {
                profile = p
            }
        }
    } }
}
