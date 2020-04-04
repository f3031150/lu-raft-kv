package cn.think.in.java;

import cn.think.in.java.entity.LogEntry;

/**
 * 日志条目集；每一个条目包含一个用户状态机执行的指令，和leader收到该指令时的任期号
 * @see cn.think.in.java.entity.LogEntry
 * @author 莫那·鲁道
 */
public interface LogModule {

    void write(LogEntry logEntry);

    LogEntry read(Long index);

    void removeOnStartIndex(Long startIndex);

    LogEntry getLast();

    Long getLastIndex();
}
