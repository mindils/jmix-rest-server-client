package com.company.app.view.packetdocument;

import com.company.app.entity.PacketDocument;
import com.company.app.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "packet-documents/:id", layout = MainView.class)
@ViewController(id = "PacketDocument.detail")
@ViewDescriptor(path = "packet-document-detail-view.xml")
@EditedEntityContainer("packetDocumentDc")
public class PacketDocumentDetailView extends StandardDetailView<PacketDocument> {

}
