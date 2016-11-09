/**
 * Copyright 2005-2013 Dozer Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dozer.builder;

import com.google.protobuf.Message;
import org.dozer.BeanBuilder;
import org.dozer.factory.BeanCreationDirective;
import org.dozer.util.ProtoUtils;

/**
 * @author Dmitry Spikhalskiy
 */
public class ByProtobufBuilder implements BeanBuilderCreationStrategy {

  public boolean isApplicable(BeanCreationDirective directive) {
    return Message.class.isAssignableFrom(directive.getActualClass());
  }

  public BeanBuilder create(BeanCreationDirective directive) {
    Class<? extends Message> messageClass = (Class<? extends Message>)directive.getActualClass();
    final Message.Builder protoBuilder = ProtoUtils.getBuilder(messageClass);
    return new ProtoBeanBuilder(protoBuilder, messageClass);
  }
}
