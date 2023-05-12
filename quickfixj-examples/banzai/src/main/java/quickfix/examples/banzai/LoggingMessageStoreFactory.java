package quickfix.examples.banzai;

import quickfix.MessageStore;
import quickfix.MessageStoreFactory;
import quickfix.SessionID;

public class LoggingMessageStoreFactory implements MessageStoreFactory {
    private MessageStoreFactory factory;

    public LoggingMessageStoreFactory(MessageStoreFactory factory) {
        this.factory = factory;
    }

    @Override
    public MessageStore create(SessionID sessionID) {
        MessageStore target = factory.create(sessionID);
        return new LoggingMessageStore(target);
    }
}
