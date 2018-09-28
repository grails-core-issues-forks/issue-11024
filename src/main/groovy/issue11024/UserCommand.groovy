package issue11024

import grails.validation.Validateable
import groovy.transform.ToString

@ToString
class UserCommand implements Validateable {
    String name
}
