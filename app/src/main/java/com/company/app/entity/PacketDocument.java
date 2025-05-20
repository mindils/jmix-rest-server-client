package com.company.app.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.Store;
import io.jmix.restds.annotation.RestDataStoreEntity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Store(name = "serviceapp")
@RestDataStoreEntity(remoteName = "packet_PacketDocument")
public class PacketDocument {

  private UUID id;

  private String documents;

  private String status;

  private LocalDateTime availableFrom;

  private String content;

  private String documentType;

  private Boolean correctPacket;

  private String inn;

  private String kpp;

  private String errorMessage;

  private OffsetDateTime createdDate;

  private OffsetDateTime lastModifiedDate;

  public OffsetDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public Boolean getCorrectPacket() {
    return correctPacket;
  }


  public String getErrorMessage() { return errorMessage; }
  public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

  public String getDocuments() {
    return documents;
  }

  public void setDocuments(String documents) {
    this.documents = documents;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getDocumentType() {
    return documentType;
  }

  public Boolean isCorrectPacket() {
    return correctPacket;
  }

  public String getKpp() {
    return kpp;
  }

  public void setKpp(String kpp) {
    this.kpp = kpp;
  }

  public String getInn() {
    return inn;
  }

  public void setInn(String inn) {
    this.inn = inn;
  }

  public void setCorrectPacket(Boolean packetFull) {
    this.correctPacket = packetFull;
  }

  public LocalDateTime getAvailableFrom() {
    return availableFrom;
  }

  public void setAvailableFrom(LocalDateTime availableFrom) {
    this.availableFrom = availableFrom;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}