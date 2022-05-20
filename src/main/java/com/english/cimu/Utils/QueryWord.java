package com.english.cimu.Utils;

import com.english.cimu.WordSql.QueryHandler;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.stereotype.Component;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/6 0:41
 */
@Component
public class QueryWord {
    // word 单词拼写
    public String queryForEn(String word) throws TException {
        TTransport transport = null;
        String res = null;
        try {
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            QueryHandler.Client client = new QueryHandler.Client(protocol);
            // 按英文查
            res = client.query(word);
        } catch (TException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
        return res;
    }

    // mean 中文意思，limit，返回多少个具有该意思的单词
    public String queryForZh(String mean, Integer limit) throws TException {
        TTransport transport = null;
        String res = null;
        try {
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            QueryHandler.Client client = new QueryHandler.Client(protocol);
            // 按英文查
            res = client.queryZH(mean, limit);
        } catch (TException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
        return res;
    }
}
