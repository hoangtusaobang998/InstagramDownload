package com.tt.dev.instagramdownload.androidnetworking;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

 class Dimensions {

    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
 class Dimensions_ {

    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
 class DisplayResource {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("config_width")
    @Expose
    private Integer configWidth;
    @SerializedName("config_height")
    @Expose
    private Integer configHeight;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getConfigWidth() {
        return configWidth;
    }

    public void setConfigWidth(Integer configWidth) {
        this.configWidth = configWidth;
    }

    public Integer getConfigHeight() {
        return configHeight;
    }

    public void setConfigHeight(Integer configHeight) {
        this.configHeight = configHeight;
    }

}
 class DisplayResource_ {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("config_width")
    @Expose
    private Integer configWidth;
    @SerializedName("config_height")
    @Expose
    private Integer configHeight;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getConfigWidth() {
        return configWidth;
    }

    public void setConfigWidth(Integer configWidth) {
        this.configWidth = configWidth;
    }

    public Integer getConfigHeight() {
        return configHeight;
    }

    public void setConfigHeight(Integer configHeight) {
        this.configHeight = configHeight;
    }

}
 class Edge {

    @SerializedName("node")
    @Expose
    private Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

}
 class EdgeLikedBy {

    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
 class EdgeLikedBy_ {

    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
 class EdgeLikedBy__ {

    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
 class EdgeMediaPreviewComment {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("edges")
    @Expose
    private List<Edge___> edges = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Edge___> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge___> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaPreviewLike {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("edges")
    @Expose
    private List<Object> edges = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaToCaption {

    @SerializedName("edges")
    @Expose
    private List<Edge> edges = null;

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaToHoistedComment {

    @SerializedName("edges")
    @Expose
    private List<Object> edges = null;

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaToParentComment {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("page_info")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("edges")
    @Expose
    private List<Edge_> edges = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Edge_> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge_> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaToSponsorUser {

    @SerializedName("edges")
    @Expose
    private List<Object> edges = null;

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaToTaggedUser {

    @SerializedName("edges")
    @Expose
    private List<Object> edges = null;

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

}
 class EdgeMediaToTaggedUser_ {

    @SerializedName("edges")
    @Expose
    private List<Object> edges = null;

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

}
 class EdgeSidecarToChildren {

    @SerializedName("edges")
    @Expose
    private List<Edge____> edges = null;

    public List<Edge____> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge____> edges) {
        this.edges = edges;
    }

}
 class EdgeThreadedComments {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("page_info")
    @Expose
    private PageInfo_ pageInfo;
    @SerializedName("edges")
    @Expose
    private List<Edge__> edges = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PageInfo_ getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo_ pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Edge__> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge__> edges) {
        this.edges = edges;
    }

}
 class EdgeWebMediaToRelatedMedia {

    @SerializedName("edges")
    @Expose
    private List<Object> edges = null;

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

}
 class Edge_ {

    @SerializedName("node")
    @Expose
    private Node_ node;

    public Node_ getNode() {
        return node;
    }

    public void setNode(Node_ node) {
        this.node = node;
    }

}
 class Edge__ {

    @SerializedName("node")
    @Expose
    private Node__ node;

    public Node__ getNode() {
        return node;
    }

    public void setNode(Node__ node) {
        this.node = node;
    }

}
 class Edge___ {

    @SerializedName("node")
    @Expose
    private Node___ node;

    public Node___ getNode() {
        return node;
    }

    public void setNode(Node___ node) {
        this.node = node;
    }

}
 class Edge____ {

    @SerializedName("node")
    @Expose
    private Node____ node;

    public Node____ getNode() {
        return node;
    }

    public void setNode(Node____ node) {
        this.node = node;
    }

}
 class Graphql {

    @SerializedName("shortcode_media")
    @Expose
    private ShortcodeMedia shortcodeMedia;

    public ShortcodeMedia getShortcodeMedia() {
        return shortcodeMedia;
    }

    public void setShortcodeMedia(ShortcodeMedia shortcodeMedia) {
        this.shortcodeMedia = shortcodeMedia;
    }

}
 public class ListIMG {

    @SerializedName("graphql")
    @Expose
    private Graphql graphql;

    public Graphql getGraphql() {
        return graphql;
    }

    public void setGraphql(Graphql graphql) {
        this.graphql = graphql;
    }

}
 class Location {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("has_public_page")
    @Expose
    private Boolean hasPublicPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("address_json")
    @Expose
    private String addressJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getHasPublicPage() {
        return hasPublicPage;
    }

    public void setHasPublicPage(Boolean hasPublicPage) {
        this.hasPublicPage = hasPublicPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAddressJson() {
        return addressJson;
    }

    public void setAddressJson(String addressJson) {
        this.addressJson = addressJson;
    }

}
 class Node {

    @SerializedName("text")
    @Expose
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
 class Node_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("did_report_as_spam")
    @Expose
    private Boolean didReportAsSpam;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("viewer_has_liked")
    @Expose
    private Boolean viewerHasLiked;
    @SerializedName("edge_liked_by")
    @Expose
    private EdgeLikedBy edgeLikedBy;
    @SerializedName("is_restricted_pending")
    @Expose
    private Boolean isRestrictedPending;
    @SerializedName("edge_threaded_comments")
    @Expose
    private EdgeThreadedComments edgeThreadedComments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDidReportAsSpam() {
        return didReportAsSpam;
    }

    public void setDidReportAsSpam(Boolean didReportAsSpam) {
        this.didReportAsSpam = didReportAsSpam;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getViewerHasLiked() {
        return viewerHasLiked;
    }

    public void setViewerHasLiked(Boolean viewerHasLiked) {
        this.viewerHasLiked = viewerHasLiked;
    }

    public EdgeLikedBy getEdgeLikedBy() {
        return edgeLikedBy;
    }

    public void setEdgeLikedBy(EdgeLikedBy edgeLikedBy) {
        this.edgeLikedBy = edgeLikedBy;
    }

    public Boolean getIsRestrictedPending() {
        return isRestrictedPending;
    }

    public void setIsRestrictedPending(Boolean isRestrictedPending) {
        this.isRestrictedPending = isRestrictedPending;
    }

    public EdgeThreadedComments getEdgeThreadedComments() {
        return edgeThreadedComments;
    }

    public void setEdgeThreadedComments(EdgeThreadedComments edgeThreadedComments) {
        this.edgeThreadedComments = edgeThreadedComments;
    }

}
 class Node__ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("did_report_as_spam")
    @Expose
    private Boolean didReportAsSpam;
    @SerializedName("owner")
    @Expose
    private Owner_ owner;
    @SerializedName("viewer_has_liked")
    @Expose
    private Boolean viewerHasLiked;
    @SerializedName("edge_liked_by")
    @Expose
    private EdgeLikedBy_ edgeLikedBy;
    @SerializedName("is_restricted_pending")
    @Expose
    private Boolean isRestrictedPending;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDidReportAsSpam() {
        return didReportAsSpam;
    }

    public void setDidReportAsSpam(Boolean didReportAsSpam) {
        this.didReportAsSpam = didReportAsSpam;
    }

    public Owner_ getOwner() {
        return owner;
    }

    public void setOwner(Owner_ owner) {
        this.owner = owner;
    }

    public Boolean getViewerHasLiked() {
        return viewerHasLiked;
    }

    public void setViewerHasLiked(Boolean viewerHasLiked) {
        this.viewerHasLiked = viewerHasLiked;
    }

    public EdgeLikedBy_ getEdgeLikedBy() {
        return edgeLikedBy;
    }

    public void setEdgeLikedBy(EdgeLikedBy_ edgeLikedBy) {
        this.edgeLikedBy = edgeLikedBy;
    }

    public Boolean getIsRestrictedPending() {
        return isRestrictedPending;
    }

    public void setIsRestrictedPending(Boolean isRestrictedPending) {
        this.isRestrictedPending = isRestrictedPending;
    }

}
 class Node___ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("did_report_as_spam")
    @Expose
    private Boolean didReportAsSpam;
    @SerializedName("owner")
    @Expose
    private Owner__ owner;
    @SerializedName("viewer_has_liked")
    @Expose
    private Boolean viewerHasLiked;
    @SerializedName("edge_liked_by")
    @Expose
    private EdgeLikedBy__ edgeLikedBy;
    @SerializedName("is_restricted_pending")
    @Expose
    private Boolean isRestrictedPending;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDidReportAsSpam() {
        return didReportAsSpam;
    }

    public void setDidReportAsSpam(Boolean didReportAsSpam) {
        this.didReportAsSpam = didReportAsSpam;
    }

    public Owner__ getOwner() {
        return owner;
    }

    public void setOwner(Owner__ owner) {
        this.owner = owner;
    }

    public Boolean getViewerHasLiked() {
        return viewerHasLiked;
    }

    public void setViewerHasLiked(Boolean viewerHasLiked) {
        this.viewerHasLiked = viewerHasLiked;
    }

    public EdgeLikedBy__ getEdgeLikedBy() {
        return edgeLikedBy;
    }

    public void setEdgeLikedBy(EdgeLikedBy__ edgeLikedBy) {
        this.edgeLikedBy = edgeLikedBy;
    }

    public Boolean getIsRestrictedPending() {
        return isRestrictedPending;
    }

    public void setIsRestrictedPending(Boolean isRestrictedPending) {
        this.isRestrictedPending = isRestrictedPending;
    }

}
 class Node____ {

    @SerializedName("__typename")
    @Expose
    private String typename;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortcode")
    @Expose
    private String shortcode;
    @SerializedName("dimensions")
    @Expose
    private Dimensions_ dimensions;
    @SerializedName("gating_info")
    @Expose
    private Object gatingInfo;
    @SerializedName("fact_check_overall_rating")
    @Expose
    private Object factCheckOverallRating;
    @SerializedName("fact_check_information")
    @Expose
    private Object factCheckInformation;
    @SerializedName("media_preview")
    @Expose
    private String mediaPreview;
    @SerializedName("display_url")
    @Expose
    private String displayUrl;
    @SerializedName("display_resources")
    @Expose
    private List<DisplayResource_> displayResources = null;
    @SerializedName("accessibility_caption")
    @Expose
    private String accessibilityCaption;
    @SerializedName("is_video")
    @Expose
    private Boolean isVideo;
    @SerializedName("tracking_token")
    @Expose
    private String trackingToken;
    @SerializedName("edge_media_to_tagged_user")
    @Expose
    private EdgeMediaToTaggedUser_ edgeMediaToTaggedUser;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Dimensions_ getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions_ dimensions) {
        this.dimensions = dimensions;
    }

    public Object getGatingInfo() {
        return gatingInfo;
    }

    public void setGatingInfo(Object gatingInfo) {
        this.gatingInfo = gatingInfo;
    }

    public Object getFactCheckOverallRating() {
        return factCheckOverallRating;
    }

    public void setFactCheckOverallRating(Object factCheckOverallRating) {
        this.factCheckOverallRating = factCheckOverallRating;
    }

    public Object getFactCheckInformation() {
        return factCheckInformation;
    }

    public void setFactCheckInformation(Object factCheckInformation) {
        this.factCheckInformation = factCheckInformation;
    }

    public String getMediaPreview() {
        return mediaPreview;
    }

    public void setMediaPreview(String mediaPreview) {
        this.mediaPreview = mediaPreview;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public List<DisplayResource_> getDisplayResources() {
        return displayResources;
    }

    public void setDisplayResources(List<DisplayResource_> displayResources) {
        this.displayResources = displayResources;
    }

    public String getAccessibilityCaption() {
        return accessibilityCaption;
    }

    public void setAccessibilityCaption(String accessibilityCaption) {
        this.accessibilityCaption = accessibilityCaption;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public String getTrackingToken() {
        return trackingToken;
    }

    public void setTrackingToken(String trackingToken) {
        this.trackingToken = trackingToken;
    }

    public EdgeMediaToTaggedUser_ getEdgeMediaToTaggedUser() {
        return edgeMediaToTaggedUser;
    }

    public void setEdgeMediaToTaggedUser(EdgeMediaToTaggedUser_ edgeMediaToTaggedUser) {
        this.edgeMediaToTaggedUser = edgeMediaToTaggedUser;
    }

}
 class Owner {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    @SerializedName("profile_pic_url")
    @Expose
    private String profilePicUrl;
    @SerializedName("username")
    @Expose
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
 class Owner_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    @SerializedName("profile_pic_url")
    @Expose
    private String profilePicUrl;
    @SerializedName("username")
    @Expose
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
 class Owner__ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    @SerializedName("profile_pic_url")
    @Expose
    private String profilePicUrl;
    @SerializedName("username")
    @Expose
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
class Owner___ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    @SerializedName("profile_pic_url")
    @Expose
    private String profilePicUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("blocked_by_viewer")
    @Expose
    private Boolean blockedByViewer;
    @SerializedName("restricted_by_viewer")
    @Expose
    private Boolean restrictedByViewer;
    @SerializedName("followed_by_viewer")
    @Expose
    private Boolean followedByViewer;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("has_blocked_viewer")
    @Expose
    private Boolean hasBlockedViewer;
    @SerializedName("is_private")
    @Expose
    private Boolean isPrivate;
    @SerializedName("is_unpublished")
    @Expose
    private Boolean isUnpublished;
    @SerializedName("requested_by_viewer")
    @Expose
    private Boolean requestedByViewer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getBlockedByViewer() {
        return blockedByViewer;
    }

    public void setBlockedByViewer(Boolean blockedByViewer) {
        this.blockedByViewer = blockedByViewer;
    }

    public Boolean getRestrictedByViewer() {
        return restrictedByViewer;
    }

    public void setRestrictedByViewer(Boolean restrictedByViewer) {
        this.restrictedByViewer = restrictedByViewer;
    }

    public Boolean getFollowedByViewer() {
        return followedByViewer;
    }

    public void setFollowedByViewer(Boolean followedByViewer) {
        this.followedByViewer = followedByViewer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getHasBlockedViewer() {
        return hasBlockedViewer;
    }

    public void setHasBlockedViewer(Boolean hasBlockedViewer) {
        this.hasBlockedViewer = hasBlockedViewer;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Boolean getIsUnpublished() {
        return isUnpublished;
    }

    public void setIsUnpublished(Boolean isUnpublished) {
        this.isUnpublished = isUnpublished;
    }

    public Boolean getRequestedByViewer() {
        return requestedByViewer;
    }

    public void setRequestedByViewer(Boolean requestedByViewer) {
        this.requestedByViewer = requestedByViewer;
    }

}
 class PageInfo {

    @SerializedName("has_next_page")
    @Expose
    private Boolean hasNextPage;
    @SerializedName("end_cursor")
    @Expose
    private String endCursor;

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getEndCursor() {
        return endCursor;
    }

    public void setEndCursor(String endCursor) {
        this.endCursor = endCursor;
    }

}
class PageInfo_ {

    @SerializedName("has_next_page")
    @Expose
    private Boolean hasNextPage;
    @SerializedName("end_cursor")
    @Expose
    private Object endCursor;

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public Object getEndCursor() {
        return endCursor;
    }

    public void setEndCursor(Object endCursor) {
        this.endCursor = endCursor;
    }

}
class ShortcodeMedia {

    @SerializedName("__typename")
    @Expose
    private String typename;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortcode")
    @Expose
    private String shortcode;
    @SerializedName("dimensions")
    @Expose
    private Dimensions dimensions;
    @SerializedName("gating_info")
    @Expose
    private Object gatingInfo;
    @SerializedName("fact_check_overall_rating")
    @Expose
    private Object factCheckOverallRating;
    @SerializedName("fact_check_information")
    @Expose
    private Object factCheckInformation;
    @SerializedName("media_preview")
    @Expose
    private Object mediaPreview;
    @SerializedName("display_url")
    @Expose
    private String displayUrl;
    @SerializedName("display_resources")
    @Expose
    private List<DisplayResource> displayResources = null;
    @SerializedName("is_video")
    @Expose
    private Boolean isVideo;
    @SerializedName("tracking_token")
    @Expose
    private String trackingToken;
    @SerializedName("edge_media_to_tagged_user")
    @Expose
    private EdgeMediaToTaggedUser edgeMediaToTaggedUser;
    @SerializedName("edge_media_to_caption")
    @Expose
    private EdgeMediaToCaption edgeMediaToCaption;
    @SerializedName("caption_is_edited")
    @Expose
    private Boolean captionIsEdited;
    @SerializedName("has_ranked_comments")
    @Expose
    private Boolean hasRankedComments;
    @SerializedName("edge_media_to_parent_comment")
    @Expose
    private EdgeMediaToParentComment edgeMediaToParentComment;
    @SerializedName("edge_media_to_hoisted_comment")
    @Expose
    private EdgeMediaToHoistedComment edgeMediaToHoistedComment;
    @SerializedName("edge_media_preview_comment")
    @Expose
    private EdgeMediaPreviewComment edgeMediaPreviewComment;
    @SerializedName("comments_disabled")
    @Expose
    private Boolean commentsDisabled;
    @SerializedName("commenting_disabled_for_viewer")
    @Expose
    private Boolean commentingDisabledForViewer;
    @SerializedName("taken_at_timestamp")
    @Expose
    private Integer takenAtTimestamp;
    @SerializedName("edge_media_preview_like")
    @Expose
    private EdgeMediaPreviewLike edgeMediaPreviewLike;
    @SerializedName("edge_media_to_sponsor_user")
    @Expose
    private EdgeMediaToSponsorUser edgeMediaToSponsorUser;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("viewer_has_liked")
    @Expose
    private Boolean viewerHasLiked;
    @SerializedName("viewer_has_saved")
    @Expose
    private Boolean viewerHasSaved;
    @SerializedName("viewer_has_saved_to_collection")
    @Expose
    private Boolean viewerHasSavedToCollection;
    @SerializedName("viewer_in_photo_of_you")
    @Expose
    private Boolean viewerInPhotoOfYou;
    @SerializedName("viewer_can_reshare")
    @Expose
    private Boolean viewerCanReshare;
    @SerializedName("owner")
    @Expose
    private Owner___ owner;
    @SerializedName("is_ad")
    @Expose
    private Boolean isAd;
    @SerializedName("edge_web_media_to_related_media")
    @Expose
    private EdgeWebMediaToRelatedMedia edgeWebMediaToRelatedMedia;
    @SerializedName("edge_sidecar_to_children")
    @Expose
    private EdgeSidecarToChildren edgeSidecarToChildren;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Object getGatingInfo() {
        return gatingInfo;
    }

    public void setGatingInfo(Object gatingInfo) {
        this.gatingInfo = gatingInfo;
    }

    public Object getFactCheckOverallRating() {
        return factCheckOverallRating;
    }

    public void setFactCheckOverallRating(Object factCheckOverallRating) {
        this.factCheckOverallRating = factCheckOverallRating;
    }

    public Object getFactCheckInformation() {
        return factCheckInformation;
    }

    public void setFactCheckInformation(Object factCheckInformation) {
        this.factCheckInformation = factCheckInformation;
    }

    public Object getMediaPreview() {
        return mediaPreview;
    }

    public void setMediaPreview(Object mediaPreview) {
        this.mediaPreview = mediaPreview;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public List<DisplayResource> getDisplayResources() {
        return displayResources;
    }

    public void setDisplayResources(List<DisplayResource> displayResources) {
        this.displayResources = displayResources;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public String getTrackingToken() {
        return trackingToken;
    }

    public void setTrackingToken(String trackingToken) {
        this.trackingToken = trackingToken;
    }

    public EdgeMediaToTaggedUser getEdgeMediaToTaggedUser() {
        return edgeMediaToTaggedUser;
    }

    public void setEdgeMediaToTaggedUser(EdgeMediaToTaggedUser edgeMediaToTaggedUser) {
        this.edgeMediaToTaggedUser = edgeMediaToTaggedUser;
    }

    public EdgeMediaToCaption getEdgeMediaToCaption() {
        return edgeMediaToCaption;
    }

    public void setEdgeMediaToCaption(EdgeMediaToCaption edgeMediaToCaption) {
        this.edgeMediaToCaption = edgeMediaToCaption;
    }

    public Boolean getCaptionIsEdited() {
        return captionIsEdited;
    }

    public void setCaptionIsEdited(Boolean captionIsEdited) {
        this.captionIsEdited = captionIsEdited;
    }

    public Boolean getHasRankedComments() {
        return hasRankedComments;
    }

    public void setHasRankedComments(Boolean hasRankedComments) {
        this.hasRankedComments = hasRankedComments;
    }

    public EdgeMediaToParentComment getEdgeMediaToParentComment() {
        return edgeMediaToParentComment;
    }

    public void setEdgeMediaToParentComment(EdgeMediaToParentComment edgeMediaToParentComment) {
        this.edgeMediaToParentComment = edgeMediaToParentComment;
    }

    public EdgeMediaToHoistedComment getEdgeMediaToHoistedComment() {
        return edgeMediaToHoistedComment;
    }

    public void setEdgeMediaToHoistedComment(EdgeMediaToHoistedComment edgeMediaToHoistedComment) {
        this.edgeMediaToHoistedComment = edgeMediaToHoistedComment;
    }

    public EdgeMediaPreviewComment getEdgeMediaPreviewComment() {
        return edgeMediaPreviewComment;
    }

    public void setEdgeMediaPreviewComment(EdgeMediaPreviewComment edgeMediaPreviewComment) {
        this.edgeMediaPreviewComment = edgeMediaPreviewComment;
    }

    public Boolean getCommentsDisabled() {
        return commentsDisabled;
    }

    public void setCommentsDisabled(Boolean commentsDisabled) {
        this.commentsDisabled = commentsDisabled;
    }

    public Boolean getCommentingDisabledForViewer() {
        return commentingDisabledForViewer;
    }

    public void setCommentingDisabledForViewer(Boolean commentingDisabledForViewer) {
        this.commentingDisabledForViewer = commentingDisabledForViewer;
    }

    public Integer getTakenAtTimestamp() {
        return takenAtTimestamp;
    }

    public void setTakenAtTimestamp(Integer takenAtTimestamp) {
        this.takenAtTimestamp = takenAtTimestamp;
    }

    public EdgeMediaPreviewLike getEdgeMediaPreviewLike() {
        return edgeMediaPreviewLike;
    }

    public void setEdgeMediaPreviewLike(EdgeMediaPreviewLike edgeMediaPreviewLike) {
        this.edgeMediaPreviewLike = edgeMediaPreviewLike;
    }

    public EdgeMediaToSponsorUser getEdgeMediaToSponsorUser() {
        return edgeMediaToSponsorUser;
    }

    public void setEdgeMediaToSponsorUser(EdgeMediaToSponsorUser edgeMediaToSponsorUser) {
        this.edgeMediaToSponsorUser = edgeMediaToSponsorUser;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getViewerHasLiked() {
        return viewerHasLiked;
    }

    public void setViewerHasLiked(Boolean viewerHasLiked) {
        this.viewerHasLiked = viewerHasLiked;
    }

    public Boolean getViewerHasSaved() {
        return viewerHasSaved;
    }

    public void setViewerHasSaved(Boolean viewerHasSaved) {
        this.viewerHasSaved = viewerHasSaved;
    }

    public Boolean getViewerHasSavedToCollection() {
        return viewerHasSavedToCollection;
    }

    public void setViewerHasSavedToCollection(Boolean viewerHasSavedToCollection) {
        this.viewerHasSavedToCollection = viewerHasSavedToCollection;
    }

    public Boolean getViewerInPhotoOfYou() {
        return viewerInPhotoOfYou;
    }

    public void setViewerInPhotoOfYou(Boolean viewerInPhotoOfYou) {
        this.viewerInPhotoOfYou = viewerInPhotoOfYou;
    }

    public Boolean getViewerCanReshare() {
        return viewerCanReshare;
    }

    public void setViewerCanReshare(Boolean viewerCanReshare) {
        this.viewerCanReshare = viewerCanReshare;
    }

    public Owner___ getOwner() {
        return owner;
    }

    public void setOwner(Owner___ owner) {
        this.owner = owner;
    }

    public Boolean getIsAd() {
        return isAd;
    }

    public void setIsAd(Boolean isAd) {
        this.isAd = isAd;
    }

    public EdgeWebMediaToRelatedMedia getEdgeWebMediaToRelatedMedia() {
        return edgeWebMediaToRelatedMedia;
    }

    public void setEdgeWebMediaToRelatedMedia(EdgeWebMediaToRelatedMedia edgeWebMediaToRelatedMedia) {
        this.edgeWebMediaToRelatedMedia = edgeWebMediaToRelatedMedia;
    }

    public EdgeSidecarToChildren getEdgeSidecarToChildren() {
        return edgeSidecarToChildren;
    }

    public void setEdgeSidecarToChildren(EdgeSidecarToChildren edgeSidecarToChildren) {
        this.edgeSidecarToChildren = edgeSidecarToChildren;
    }

}