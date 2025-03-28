package com.lucaspowered.switches_cpanel
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import kotlinx.serialization.json.Json
import java.nio.file.Files
import kotlin.io.path.Path

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
actual class SwitchService : ISwitchService {
    private val switches by lazy { Json.decodeFromString<List<SwitchInfo>>(Files.readString(Path("switches.json"))) }

    override suspend fun getName(id: Int) = switches.find { it.id == id }?.name ?: "undefined"

    override suspend fun getUrl(id: Int) = switches.find { it.id == id }?.url ?: "undefined"

    override suspend fun getDesc(id: Int) = switches.find {it.id == id}?.description ?: "undefined"

    override suspend fun getCount() = switches.size
}
