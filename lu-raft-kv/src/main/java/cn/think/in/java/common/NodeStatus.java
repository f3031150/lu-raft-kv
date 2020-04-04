package cn.think.in.java.common;

import lombok.Getter;

/**
 *  任何的节点都在者三个状态变化，切换
 *  正常的情况下，集群中只有一个领导（LEADER），其他的都是跟随着（FOLLOWER）
 * @author 莫那·鲁道
 */
public interface NodeStatus {

    int FOLLOWER = 0; // 跟随者 ， 他是被动的，不会主动发送任何请求，只是简单得响应 候选者candidate 和 leader 得请求
    int CANDIDATE = 1; // 候选者， 是用来选举一个新的leader
    int LEADER = 2; // 领导， 处理所有的客户端请求，如果客户端请求到follower ，那么都会重定向到leader

    @Getter
    enum Enum {
        FOLLOWER(0), CANDIDATE(1), LEADER(2);

        Enum(int code) {
            this.code = code;
        }

        int code;

        public static Enum value(int i) {
            for (Enum value : Enum.values()) {
                if (value.code == i) {
                    return value;
                }
            }
            return null;
        }

    }

}
