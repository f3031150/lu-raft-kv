package cn.think.in.java.entity;

import cn.think.in.java.Consensus;
import lombok.Getter;
import lombok.Setter;

/**
 * 请求投票 RPC 参数.
 *
 *
 * 接收器实现:
 * 1.当 term < currentTerm 时回复 false (5.1)
 * 2.如果votedFor为空或candidateId，并且候选人的日志至少与接收者的日志一样最新，则授予投票权 （5.2 , 5.4)
 *
 * @author 莫那·鲁道
 * @see Consensus#requestVote(RvoteParam)
 */
@Getter
@Setter
public class RvoteParam extends BaseParam {

    /** 请求选票的候选人的 Id(ip:selfPort) */
    String candidateId;

    /** 候选人的最后日志条目的索引值 */
    long lastLogIndex; // 每个新的集群节点第一次启动都是 -1 开始

    /** 候选人最后日志条目的任期号  */
    long lastLogTerm; // 从 0开始

    private RvoteParam(Builder builder) {
        setTerm(builder.term);
        setServerId(builder.serverId);
        setCandidateId(builder.candidateId);
        setLastLogIndex(builder.lastLogIndex);
        setLastLogTerm(builder.lastLogTerm);
    }

    @Override
    public String toString() {
        return "RvoteParam{" +
            "candidateId='" + candidateId + '\'' +
            ", lastLogIndex=" + lastLogIndex +
            ", lastLogTerm=" + lastLogTerm +
            ", term=" + term +
            ", serverId='" + serverId + '\'' +
            '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {

        private long term;
        private String serverId;
        private String candidateId;
        private long lastLogIndex; // -1 开始
        private long lastLogTerm; // 从 0开始

        private Builder() {
        }

        public Builder term(long val) {
            term = val;
            return this;
        }

        public Builder serverId(String val) {
            serverId = val;
            return this;
        }

        public Builder candidateId(String val) {
            candidateId = val;
            return this;
        }

        public Builder lastLogIndex(long val) {
            lastLogIndex = val;
            return this;
        }

        public Builder lastLogTerm(long val) {
            lastLogTerm = val;
            return this;
        }

        public RvoteParam build() {
            return new RvoteParam(this);
        }
    }
}
