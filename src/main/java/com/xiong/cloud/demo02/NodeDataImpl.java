package com.xiong.cloud.demo02;

import com.jnrsmcu.sdk.netdevice.NodeData;

public class NodeDataImpl extends NodeData {

    protected NodeDataImpl(byte[] data, Boolean isStoreData) {
        super(data, isStoreData);
    }

}
