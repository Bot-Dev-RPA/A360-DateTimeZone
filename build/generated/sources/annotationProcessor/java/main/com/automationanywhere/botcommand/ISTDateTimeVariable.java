package com.automationanywhere.botcommand;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.toolchain.runtime.variable.SystemVariable;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ISTDateTimeVariable implements SystemVariable<StringValue> {
  private static final Logger logger = LogManager.getLogger(ISTDateTimeVariable.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  private final ISTDateTime command = new ISTDateTime();

  @Deprecated
  public StringValue get() {
    return get(null);
  }

  @Deprecated
  public StringValue get(GlobalSessionContext globalSessionContext) {
    return get(globalSessionContext,null);
  }

  public StringValue get(GlobalSessionContext globalSessionContext, Map sessionMap) {
    logger.traceEntry();
    ISTDateTime command = new ISTDateTime();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    try {
      StringValue result = command.formattedDate();
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","formattedDate"));
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
