package org.apache.gora.elasticsearch.store;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.gora.persistency.impl.PersistentBase;
import org.apache.gora.query.PartitionQuery;
import org.apache.gora.query.Query;
import org.apache.gora.query.Result;
import org.apache.gora.store.DataStoreFactory;
import org.apache.gora.store.impl.DataStoreBase;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ElasticSearchStore<K, T extends PersistentBase> extends DataStoreBase<K, T> {

  protected static final String INSTANCE_NAME_PROPERTY = "es.host";
  protected static final String ZOOKEEPERS_NAME_PROPERTY = "es.port";
  protected static final String USERNAME_PROPERTY = "es.cluster";
  protected static final String ELASTICSEARCH_MAPPING = "es.mapping";
  protected static final String DEFAULT_MAPPING_FILE = "gora-elasticsearch-mapping.xml";

  private ElasticSearchMapping mapping;

  @Override
  public void initialize(Class<K> keyClass, Class<T> persistentClass, Properties properties) {
    // TODO Auto-generated method stub
    super.initialize(keyClass, persistentClass, properties);

    try {
      String mappingFile = DataStoreFactory.getMappingFile(properties, this, DEFAULT_MAPPING_FILE);

      mapping = readMapping(mappingFile);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public String getSchemaName() {
    // TODO Auto-generated method stub
    return mapping.getSchemaName();
  }

  @Override
  public void createSchema() {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteSchema() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean schemaExists() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public T get(K key, String[] fields) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void put(K key, T obj) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean delete(K key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public long deleteByQuery(Query<K, T> query) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Result<K, T> execute(Query<K, T> query) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Query<K, T> newQuery() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<PartitionQuery<K, T>> getPartitions(Query<K, T> query) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub

  }

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }

  @SuppressWarnings("unchecked")
  private ElasticSearchMapping readMapping(String mappingFile) {
    // TODO Auto-generated method stub

    ElasticSearchMapping mapping = new ElasticSearchMapping();
    SAXBuilder builder = new SAXBuilder();
    Document doc;
    try {
      doc = builder.build(getClass().getClassLoader().getResourceAsStream(mappingFile));

      System.out.println(doc);
      List<Element> classes = doc.getRootElement().getChildren("class");

      for (Element classElement : classes) {
        if (classElement.getAttributeValue("keyClass").equals(keyClass.getCanonicalName())
            && classElement.getAttributeValue("name").equals(persistentClass.getCanonicalName())) {
          String type = getSchemaName(classElement.getAttributeValue("type"), persistentClass);
          String indexname = getSchemaName(classElement.getAttributeValue("indexname"), persistentClass);
          mapping.setType(type);
          mapping.setIndexname(indexname);

        }
      }
    } catch (JDOMException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return mapping;
  }

  public static void main(String[] args) {
    System.out.println(new ElasticSearchStore<>().readMapping("gora-elasticsearch-mapping.xml").getIndexname());
  }
}
