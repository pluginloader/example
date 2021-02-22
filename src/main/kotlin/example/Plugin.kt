package example

import configs.Conf
import kotlinx.serialization.Serializable
import org.bukkit.entity.Player
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerJoinEvent
import pluginloader.api.Args
import pluginloader.api.Command
import pluginloader.api.Listener
import pluginloader.api.Sender

@Conf
private val config = Config()

@Listener(priority = EventPriority.LOW)
private fun onJoin(event: PlayerJoinEvent){
    event.player.sendMessage(config.onJoin)
}

@Command("examplecmd", op = true)//Только для опок
private fun cmd(sender: Sender, args: Args){
    if(args.isEmpty()){
        sender.sendMessage(config.exampleCmdNeedArg)
        return
    }
    sender.sendMessage(config.exampleCmd)
}

@Command("exampleplayer")
private fun examplepl(player: Player){
    player.sendMessage(config.examplePlayer)
}

@Serializable
private class Config(
    val onJoin: String = "onJoin hello",
    val exampleCmdNeedArg: String = "usage: /examplecmd [arg]",
    val exampleCmd: String = "hello %arg%",
    val examplePlayer: String = "hi, example"
)