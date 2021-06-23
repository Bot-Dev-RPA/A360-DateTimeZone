package com.automationanywhere.botcommand;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GetTimeZoneTimeCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(GetTimeZoneTimeCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    GetTimeZoneTime command = new GetTimeZoneTime();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("zoneID") && parameters.get("zoneID") != null && parameters.get("zoneID").get() != null) {
      convertedParameters.put("zoneID", parameters.get("zoneID").get());
      if(convertedParameters.get("zoneID") !=null && !(convertedParameters.get("zoneID") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","zoneID", "String", parameters.get("zoneID").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("zoneID") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","zoneID"));
    }
    if(convertedParameters.get("zoneID") != null) {
      switch((String)convertedParameters.get("zoneID")) {
        case "Asia/Kolkata" : {

        } break;
        case "America/New_York" : {

        } break;
        case "Asia/Hong_Kong" : {

        } break;
        case "Poland" : {

        } break;
        case "US/Pacific" : {

        } break;
        case "US/Eastern" : {

        } break;
        case "US/Central" : {

        } break;
        case "Australia/Sydney" : {

        } break;
        case "Europe/London" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","zoneID"));
      }
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.getDateTimeZone((String)convertedParameters.get("zoneID")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","getDateTimeZone"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
