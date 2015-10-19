package org.sursmobil.profiles

import org.gradle.api.Project

/**
 * Created by CJ on 19/10/2015.
 */
class ProfiledFiles {

    ProfiledFiles(Project project) {
        this.project = project
    }
    final Project project
    final files = []

    void file(String path) {
        files << new ProfiledFile(path)
    }

    void file(String path, Closure configure) {
        def file = new ProfiledFile(path)
        configure(file)
        files << file
    }

    class ProfiledFile {
        ProfiledFile(path) {
            this.path = path
        }
        final path
        String destDir = "${project.buildDir}"
    }
}
