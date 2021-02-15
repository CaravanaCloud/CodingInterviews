import optparse


def flaskrun(app, default_host="0.0.0.0", default_port="80"):
    """
    Takes a flask.Flask instance and runs it. Parses
    command-line flags to configure the app.
    """

    # Set up the command-line options
    parser = optparse.OptionParser()
    msg = 'Hostname of Flask app [{}]'.format(default_host)
    parser.add_option("-H", "--host",
                      help=msg,
                      default=default_host)
    msg = 'Port for Flask app [{}]'.format(default_port)
    parser.add_option("-P", "--port",
                      help=msg,
                      default=default_port)
    parser.add_option("-d", "--debug",
                      action="store_true", dest="debug",
                      help=optparse.SUPPRESS_HELP)

    options, _ = parser.parse_args()

    app.run(
        debug=options.debug,
        host=options.host,
        port=int(options.port)
    )
