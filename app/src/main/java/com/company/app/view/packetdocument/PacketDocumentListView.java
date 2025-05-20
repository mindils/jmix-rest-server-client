package com.company.app.view.packetdocument;

import com.company.app.entity.PacketDocument;
import com.company.app.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "packet-documents", layout = MainView.class)
@ViewController(id = "PacketDocument.list")
@ViewDescriptor(path = "packet-document-list-view.xml")
@LookupComponent("packetDocumentsDataGrid")
@DialogMode(width = "50em")
public class PacketDocumentListView extends StandardListView<PacketDocument> {

}
