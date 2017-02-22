package org.apache.gora.elasticsearch.query;

import org.apache.gora.persistency.impl.PersistentBase;
import org.apache.gora.query.impl.QueryBase;
import org.apache.gora.store.DataStore;

public class ElasticSearchQuery<K,T extends PersistentBase> extends QueryBase<K,T> {

  public ElasticSearchQuery(DataStore<K, T> dataStore) {
    super(dataStore);
    // TODO Auto-generated constructor stub
  }

}
