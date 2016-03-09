
package com.trayis.geocache;

public class Node {

    private double x;

    private double y;

    private double w;

    private double h;

    private Node optParent;

    private Location point;

    private NodeType nodetype = NodeType.EMPTY;

    private Node nw;

    private Node ne;

    private Node sw;

    private Node se;

    /**
     * Constructs a new quad tree node.
     *
     * @param {double} x X-coordiate of node.
     * @param {double} y Y-coordinate of node.
     * @param {double} w Width of node.
     * @param {double} h Height of node.
     * @param {Node} opt_parent Optional parent node.
     * @constructor
     */
    public Node(double x, double y, double w, double h, Node optParent) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.optParent = optParent;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Node getParent() {
        return optParent;
    }

    public void setParent(Node optParent) {
        this.optParent = optParent;
    }

    public void setPoint(Location point) {
        this.point = point;
    }

    public Location getPoint() {
        return this.point;
    }

    public void setNodeType(NodeType nodetype) {
        this.nodetype = nodetype;
    }

    public NodeType getNodeType() {
        return this.nodetype;
    }

    public void setNw(Node nw) {
        this.nw = nw;
    }

    public void setNe(Node ne) {
        this.ne = ne;
    }

    public void setSw(Node sw) {
        this.sw = sw;
    }

    public void setSe(Node se) {
        this.se = se;
    }

    public Node getNe() {
        return ne;
    }

    public Node getNw() {
        return nw;
    }

    public Node getSw() {
        return sw;
    }

    public Node getSe() {
        return se;
    }
}
