# SketchBot
*A skeleton code of a Telegram bot in Spring Boot*

Before launch the application you have to define two environment variable:
 - `telegram.bot.token`: the token released by BotFather during creation of your bot.
 - `telegram.bot.username`: the username you want to assign to your bot.

You can achieve this with the following command:

    java -Dtelegram.bot.token=<TOKEN> -Dtelegram.bot.username=<USERNSME> -jar ...

where `<TOKEN>` is the value of the api token and `<USERNAME>` is the username that you want for your bot.
