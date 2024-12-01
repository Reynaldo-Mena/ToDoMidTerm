@echo off
setlocal

REM Debugging: Confirm script execution
echo Script started with action: %1 and environment: %2 >> debug_log.txt

REM Get parameters
set ACTION=%1
set ENV=%2

REM Log file
set LOG_FILE=deploy_log.txt

REM Deployment directories
set STAGING_DIR=C:\deployments\staging
set PRODUCTION_DIR=C:\deployments\production

REM Artifact path
set ARTIFACT=target\ToDoMidTerm-1.0-SNAPSHOT.jar

REM Logging function
call :log "Starting script with action: %ACTION% for environment: %ENV%"

REM Main logic
if /I "%ACTION%"=="deploy" (
    if /I "%ENV%"=="staging" (
        call :deploy %STAGING_DIR%
    ) else if /I "%ENV%"=="production" (
        call :deploy %PRODUCTION_DIR%
    ) else (
        call :log "Invalid environment: %ENV%"
        exit /b 1
    )
) else if /I "%ACTION%"=="rollback" (
    if /I "%ENV%"=="staging" (
        call :rollback %STAGING_DIR%
    ) else if /I "%ENV%"=="production" (
        call :rollback %PRODUCTION_DIR%
    ) else (
        call :log "Invalid environment: %ENV%"
        exit /b 1
    )
) else (
    call :log "Invalid action: %ACTION%. Use 'deploy' or 'rollback'."
    exit /b 1
)

exit /b 0

:deploy
set DEPLOY_DIR=%1
call :log "Deploying to %DEPLOY_DIR%..."

REM Check if artifact exists
if not exist "%ARTIFACT%" (
    call :log "Artifact not found: %ARTIFACT%"
    exit /b 1
)

REM Simulate deployment
if not exist "%DEPLOY_DIR%" mkdir "%DEPLOY_DIR%"
copy "%ARTIFACT%" "%DEPLOY_DIR%" >nul
call :log "Artifact deployed to %DEPLOY_DIR%."

REM Simulate service restart
call :log "Restarting service for %DEPLOY_DIR% environment..."
goto :eof

:rollback
set DEPLOY_DIR=%1
call :log "Rolling back %DEPLOY_DIR%..."

REM Check for previous version
if not exist "%DEPLOY_DIR%\previous_version.jar" (
    call :log "Previous version not found in %DEPLOY_DIR%"
    exit /b 1
)

REM Rollback process
move "%DEPLOY_DIR%\previous_version.jar" "%DEPLOY_DIR%\current_version.jar" >nul
call :log "Rollback completed for %DEPLOY_DIR%."

REM Simulate service restart
call :log "Restarting service after rollback for %DEPLOY_DIR%..."
goto :eof

:log
echo %date% %time%: %~1 >> %LOG_FILE%
goto :eof
