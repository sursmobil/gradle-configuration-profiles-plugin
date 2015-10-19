package org.sursmobil.profiles

/**
 * Created by CJ on 19/10/2015.
 */
class Profile {

    Profile(name) {
        this.name = name
    }
    final String name
    final variables = [:]

    @Override
    void setProperty(String property, Object newValue) {
        variables[property] = newValue
    }

}
