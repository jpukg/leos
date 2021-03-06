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
package eu.europa.ec.leos.vo;

import eu.europa.ec.leos.vo.toctype.TocItemType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableOfContentItemVO {

    private TocItemType type;
    private String id;
    private String number;
    private String heading;
    private Integer numTagIndex;
    private Integer headingTagIndex;
    private Integer vtdIndex;
    private final List<TableOfContentItemVO> childItems = new ArrayList<>();
    private TableOfContentItemVO parentItem;

    public TableOfContentItemVO(){
    }

    public TableOfContentItemVO(TocItemType type, String id, String number, String heading, Integer numTagIndex, Integer headingTagIndex, Integer vtdIndex) {
        this.type = type;
        this.id = id;
        this.number = number;
        this.heading = heading;
        this.numTagIndex = numTagIndex;
        this.headingTagIndex = headingTagIndex;
        this.vtdIndex = vtdIndex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setNumTagIndex(Integer numTagIndex) {
        this.numTagIndex = numTagIndex;
    }

    public void setHeadingTagIndex(Integer headingTagIndex) {
        this.headingTagIndex = headingTagIndex;
    }

    public TocItemType getType() {
        return type;
    }

    public void setType(TocItemType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getHeading() {
        return heading;
    }

    public Integer getNumTagIndex() {
        return numTagIndex;
    }

    public Integer getHeadingTagIndex() {
        return headingTagIndex;
    }

    public Integer getVtdIndex() {
        return vtdIndex;
    }

    public TableOfContentItemVO getParentItem() {
        return parentItem;
    }

    public List<TableOfContentItemVO> getChildItems() {
        return childItems;
    }

    public void addChildItem(TableOfContentItemVO tableOfContentItemVO) {
        if (tableOfContentItemVO.getType().isRoot()) {
            throw new IllegalArgumentException("Cannot add a root item as a child!");
        }
        childItems.add(tableOfContentItemVO);
        tableOfContentItemVO.parentItem = this;
    }

    public void addAllChildItems(List<TableOfContentItemVO> tableOfContentItemVOList) {
        for (TableOfContentItemVO item : tableOfContentItemVOList) {
            addChildItem(item);
        }
    }

    public void removeChildItem(TableOfContentItemVO tableOfContentItemVO) {
        childItems.remove(tableOfContentItemVO);
    }

    public void removeAllChildItems() {
        childItems.clear();
    }

    public List<TableOfContentItemVO> getChildItemsView() {
        return Collections.unmodifiableList(new ArrayList<>(childItems));
    }

    public boolean areChildrenAllowed() {
        return type.areChildrenAllowed();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableOfContentItemVO that = (TableOfContentItemVO) o;

        if (heading != null ? !heading.equals(that.heading) : that.heading != null) return false;
        if (headingTagIndex != null ? !headingTagIndex.equals(that.headingTagIndex) : that.headingTagIndex != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (numTagIndex != null ? !numTagIndex.equals(that.numTagIndex) : that.numTagIndex != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (type != that.type) return false;
        if (vtdIndex != null ? !vtdIndex.equals(that.vtdIndex) : that.vtdIndex != null) return false;
        if (childItems != null ? !childItems.equals(that.childItems) : that.childItems != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (numTagIndex != null ? numTagIndex.hashCode() : 0);
        result = 31 * result + (headingTagIndex != null ? headingTagIndex.hashCode() : 0);
        result = 31 * result + (vtdIndex != null ? vtdIndex.hashCode() : 0);
        result = 31 * result + (childItems != null ? childItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TableOfContentItemVO{");
        sb.append("type=").append(type);
        sb.append(", GUID='").append(id).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", heading='").append(heading).append('\'');
        sb.append(", numTagIndex=").append(numTagIndex);
        sb.append(", headingTagIndex=").append(headingTagIndex);
        sb.append(", vtdIndex=").append(vtdIndex);
        sb.append(", childItems=").append(childItems);
        sb.append('}');
        return sb.toString();
    }
}
