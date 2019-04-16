package com.ruoyi.project.bi.service.impl;

import com.ruoyi.project.bi.service.Neo4jService;
import org.neo4j.driver.internal.value.StringValue;
import org.neo4j.driver.v1.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("neo4jService")
public class Neo4jServiceImpl implements Neo4jService
{
    public static final String logName="Neo4jServiceImpl";
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Neo4jServiceImpl.class);

    @Value("${neo4j.url}")
    private String url;

    @Value("${neo4j.username}")
    private String userName;

    @Value("${neo4j.password}")
    private String password;

    private Driver driver;

    public void init()
    {
        if(driver!=null) {
            try {
                driver.close();
            }catch (Exception e)
            {

            }
        }
        driver = GraphDatabase.driver( url, AuthTokens.basic( userName, password ) );
    }

    public List<Map> queryByCypher(String cypher)
    {
        Session session=getSession();

        if(session==null)
        {
            throw new RuntimeException("Neo4j server is not ready!url="+url+";username="+userName+";password="+password);
        }

        try
        {
            StatementResult result =  session.run(cypher);

            List ret=new ArrayList();

            while ( result.hasNext() )
            {
                Map pp=new HashMap();
                Record record = result.next();
                for(String key:record.keys())
                {
                    org.neo4j.driver.v1.Value obj = record.get(key);
                    if("STRING".equals(obj.type().name()))
                    {
                        pp.put(key,obj.asString());
                    }
                    else if("INTEGER".equals(obj.type().name()))
                    {
                        pp.put(key,obj.asInt());
                    }
                    else
                    {
                        pp.putAll(obj.asMap());
                    }

                }

                ret.add(pp);
                //System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
            }

            return ret;

        }
        catch (Exception e)
        {
            log.error(logName,"Error:"+e.getMessage(),e);
        }
        finally {
            session.close();
        }

        return null;
    }


    public void executCypher(String cypher)
    {
        Session session=getSession();

        if(session==null)
        {
            throw new RuntimeException("Neo4j server is not ready!url="+url+";username="+userName+";password="+password);
        }

        try
        {
            session.run(cypher);
        }
        catch (Exception e)
        {
            log.error(logName,"error:"+e.getMessage(),e);

           throw new RuntimeException(e.getMessage());
        }
        finally {
            session.close();
        }
    }


    public Session getSession()
    {
        Session session =null;

        try {
            session =  driver.session();
        }catch (Exception e)
        {
            init();
            session =  driver.session();
        }

        return session;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
