package quickfix.examples.banzai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.MessageStore;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class LoggingMessageStore implements MessageStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingMessageStore.class);
    private MessageStore target;

    public LoggingMessageStore(MessageStore target) {
        this.target = target;
    }

    @Override
    public boolean set(int sequence, String message) throws IOException {
        boolean result = target.set(sequence, message);
        LOGGER.info("set(sequence = {}, message = {}) returns {}", sequence, message, result);
        return result;
    }

    @Override
    public void get(int startSequence, int endSequence, Collection<String> messages) throws IOException {
        target.get(startSequence, endSequence, messages);
        LOGGER.info("get(startSequence = {}, endSequence = {}, messages), size = {}", startSequence, endSequence, messages.size());
    }

    @Override
    public int getNextSenderMsgSeqNum() throws IOException {
        int result = target.getNextSenderMsgSeqNum();
        LOGGER.info("getNextSenderMsgSeqNum() returns {}", result);
        return result;
    }

    @Override
    public int getNextTargetMsgSeqNum() throws IOException {
        int result = target.getNextTargetMsgSeqNum();
        LOGGER.info("getNextTargetMsgSeqNum() returns {}", result);
        return result;
    }

    @Override
    public void setNextSenderMsgSeqNum(int next) throws IOException {
        LOGGER.info("setNextSenderMsgSeqNum(next = {})", next);
        target.setNextSenderMsgSeqNum(next);
    }

    @Override
    public void setNextTargetMsgSeqNum(int next) throws IOException {
        LOGGER.info("setNextTargetMsgSeqNum(next = {})", next);
        target.setNextTargetMsgSeqNum(next);
    }

    @Override
    public void incrNextSenderMsgSeqNum() throws IOException {
        LOGGER.info("incrNextSenderMsgSeqNum()");
        target.incrNextSenderMsgSeqNum();
    }

    @Override
    public void incrNextTargetMsgSeqNum() throws IOException {
        LOGGER.info("incrNextTargetMsgSeqNum()");
        target.incrNextTargetMsgSeqNum();
    }

    @Override
    public Date getCreationTime() throws IOException {
        Date result = target.getCreationTime();
        LOGGER.info("getCreationTime() returns {}", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss,SSSZ").format(result));
        return result;
    }

    @Override
    public void reset() throws IOException {
        LOGGER.info("reset()");
        target.reset();
    }

    @Override
    public void refresh() throws IOException {
        LOGGER.info("refresh()");
        target.refresh();
    }
}
