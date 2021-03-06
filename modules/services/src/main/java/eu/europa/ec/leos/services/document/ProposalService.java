/*
 * Copyright 2017 European Commission
 *
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *     https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and limitations under the Licence.
 */
package eu.europa.ec.leos.services.document;

import eu.europa.ec.leos.domain.document.LeosCategory;
import eu.europa.ec.leos.domain.document.LeosDocument.XmlDocument.Proposal;
import eu.europa.ec.leos.domain.document.LeosMetadata.ProposalMetadata;

public interface ProposalService {

    Proposal createProposal(String templateId, String path, ProposalMetadata metadata);

    Proposal findProposal(String id);

    Proposal updateProposal(Proposal proposal, ProposalMetadata metadata);

    Proposal addComponentRef(Proposal proposal, String href, LeosCategory leosCategory);

    Proposal removeComponentRef(Proposal proposal, String href, LeosCategory leosCategory);
}
