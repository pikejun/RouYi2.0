package com.ruoyi.project.bi.service;

import java.util.List;
import java.util.Map;

public interface Neo4jService {
    public List<Map> queryByCypher(String cypher);
    public void executCypher(String cypher);
}
