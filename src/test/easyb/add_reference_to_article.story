
description 'User can log in with valid username/password-combination'

scenario "user can login with correct password", {
    given 'login selected'
    when 'a valid username and password are given'
    then 'user will be logged in to system'
}

scenario "user can not login with incorrect password", {
    given 'command login selected'
    when 'a valid username and incorrect password are given'
    then 'user will not be logged in to system'
}

scenario "nonexistent user can not login to system", {
    given 'command login selected'
    when 'a nonexistent username and some password are given'
    then 'user will not be logged in to system'
}