/*
 * Licensed to David Pilato (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package fr.pilato.spring.elasticsearch.it.xml.transport;

import org.elasticsearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
import org.elasticsearch.client.Client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TemplateAutoTest extends AbstractXmlContextModel {
    private final String[] xmlBeans = {"models/transport/template-auto/template-auto-context.xml"};

    @Override
    protected String indexName() {
        return null;
    }

    @Override
    String[] xmlBeans() {
        return xmlBeans;
    }

    @Override
    protected void checkUseCaseSpecific(Client client) {
        GetIndexTemplatesResponse response = client.admin().indices().prepareGetTemplates("twitter_template").get();
        assertThat(response.getIndexTemplates().size(), is(1));
    }
}
