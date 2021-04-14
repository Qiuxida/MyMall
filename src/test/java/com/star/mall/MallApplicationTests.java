package com.star.mall;

import cn.hutool.json.JSONUtil;
import com.star.mall.persistence.entity.User;
import com.star.mall.utils.UniqueIdUtil;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MallApplicationTests {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("kuang_index");
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    public void existIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("kuang_index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("kuang_index");
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    @Test
    public void createDocument() throws IOException {
        User user = new User();
        user.setId(UniqueIdUtil.getSid());
        user.setAccount("qiuxida");
        IndexRequest request = new IndexRequest("kuang_index");
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.source(JSONUtil.toJsonStr(user), XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void existDocument() throws IOException {
        GetRequest request = new GetRequest("kuang_index", "1");
        request.fetchSourceContext(new FetchSourceContext(false));
        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void getDocument() throws IOException {
        GetRequest request = new GetRequest("kuang_index", "1");
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        System.out.println(response.toString());
    }

    @Test
    public void updateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("kuang_index", "1");
        User user = new User();
        user.setAccount("admin1");
        request.doc(JSONUtil.toJsonStr(user), XContentType.JSON);
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    @Test
    public void deleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("kuang_index", "1");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    @Test
    public void bulkDocument() throws IOException {
        BulkRequest request = new BulkRequest();
        List<User> users = new ArrayList<>();

        users.forEach(item -> {
            request.add(new IndexRequest("kuang_index").id(item.getName()).source(JSONUtil.toJsonStr(item), XContentType.JSON));
        });

        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.hasFailures());
    }

    @Test
    public void search() throws IOException {
        SearchRequest request = new SearchRequest("kuang_index");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.highlighter();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "1");
        sourceBuilder.query(termQueryBuilder);

        request.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        for (SearchHit hit : response.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }
}
