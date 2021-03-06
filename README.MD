# FRC team #8016: 2021-Game Changers/Infinite Recharge Robot Code
## Repo overview:
This repository uses an alpha -> beta -> master branch system. The alpha branch is where all new additions are tested. Once
proven that the code works at least nominally, it can be pushed to beta. In beta, code can be tuned and bugs fixed, until the
code is competition ready. Once that happens, it can be pushed to master. Any code in master should be competition ready.
### Contributing
You have to be a member of FRC team 8016 to contribute. If you're adding a feature or fixing a bug in the alpha branch, create
a new branch from alpha. Make your changes there, and then open a pull request back into alpha. If you're fixing bugs or tuning
values in beta or master, make a new branch from the branch you're trying to fix, make your changes, and open a pull request back
into the branch you're trying to fix.

When creating a new branch, please name it with a description of what the branch is for, as well as your first name.

## Code formatting
When editing code, please use these formatting conventions:
- Classes should be in `UpperCamelCase`
- Methods should be in `lowerCamelCase`
- Variables should be concise but descriptive, and written in `lowerCamelCase`
- Constants should be kept soley in the Constants class, and should be written in `UPPERCASE_SEPERATED_BY_UNDERSCORES`
- When you create a method, write a comment telling us what the method does, and if necessary, how it does it.
- When you create a constant, include units either in the name or in a comment to the right of the constant declaration.
- Bracketing: follow conventions below:
```
public void ExampleMethod() {
    if(x = 1) {
        //Do something
    } else {
        //Do something else
    }
}
```
