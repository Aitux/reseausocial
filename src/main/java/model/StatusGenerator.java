package model;

public class StatusGenerator {

    public static String generateStatus(Status s) {
        StringBuilder res = new StringBuilder();
        res.append("<div class=\"card text-center\" style=\"margin-top: 1em\">\n" +
                "            <div class=\"card-header\">").append(s.getUser().getFirstname()).append(" ").append(s.getUser().getLastname()).append("</div>");
        res.append("<div class=\"card-body\">\n" +
                "                <p class=\"card-text\">").append(s.getStatus()).append("</p></div>");
        s.getListCom().forEach(x -> {
            res.append("<div class=\"card-footer text-muted\">").append(x.getUser().getFirstname()).append(" ").append(x.getUser().getLastname()).append(": ").append(x.getCommentaire()).append("</div>");
        });
        res.append("<div class=\"card-footer text-muted\">\n" +
                "                <form class=\"form\">\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <textarea class=\"form-control\" id=\"comment_" + s.getIdStatus() + "\" name=\"comment\" rows=\"1\" placeholder=\"Type your comment here..\"></textarea>\n" +
                "                    </div>\n" +
                "                    <button onclick=\"postComment(" + s.getIdStatus() + ")\" class=\"btn btn-primary\">Submit</button>\n" +
                "                </form>\n" +
                "            </div></div>");

        return res.toString();
    }
}
