module.exports = {
    get: function (req, res) {
        res.success(require("./applicationData.json"));
    }
}
