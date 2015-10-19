package org.sursmobil.profiles

import org.gradle.api.Project
import org.gradle.api.Task

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
        def f = new ProfiledFile(path)
        configure.delegate = f
        configure.resolveStrategy = Closure.DELEGATE_FIRST
        configure.call(f)
        files << f
    }

    class ProfiledFile {
        ProfiledFile(path) {
            this.path = path
        }
        final path
        Task builtBy

        void builtBy(Task task) {
            builtBy = task
        }
    }
}
